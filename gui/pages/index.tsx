import {useState} from "react";
import axios from 'axios';
import Button from "@/components/Button";

export default function Home() {
    const default_value = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
    const [text, setText] = useState(default_value)
    const [chosenTranformations, setChosenTransformation] = useState({})
    const maxChars = 400
    const transformations =  ["upper", "lower", "capitalize", "inverse", "short", "extend", "number"]
    const [textAfterTransformation, setTextAfterTransformation] = useState("");
    const textSetter = (event: { target: { value: string }}) => {
        const input = event.target.value
        if (input.length <= maxChars) {
            setText(input);
        }
        else{
            console.log("dodaj triggerowanie animacji")
        }
    }

    const AddTransformation = event => {
        console.log(chosenTranformations);
        setChosenTransformation((prevState) => {
            return {...prevState,
                [Math.random()]: event.target.value};
        });
    }
    const RemoveTransformation = (event) => {
        const toRm = event.target.id;
        setChosenTransformation((prevState) => {
            const {[toRm]: removedTransformation, ...rest } = prevState;
            return rest;
        });
    };
    const sendTextTransformRequest =  async() => {
        try {
            const response = await axios.get('http://localhost:8080/transform', {
                params: {
                    transforms: Object.values(chosenTranformations).join(','),
                    text: text
                }
            });

            // Przetworzenie odpowiedzi
            const transformedText = response.data;
            setTextAfterTransformation(transformedText);
            console.log(textAfterTransformation);
        } catch (error) {
            console.error('Error during text transformation request:', error.message);
            throw error;
        }
    }

    return (
        <div className={"bg-pink-200 min-h-screen"}>
            <header
                className={"bg-pink-500 text-4xl text-amber-50 sticky pl-6 py-4 font-bold shadow-[0_35px_60px_-15px_rgba(255,192,203,0.9)]"}>
                TextTransformer
            </header>
            <div className="flex mt-8 mx-12 gap-12 h-80">
                <div className={"w-1/2 flex flex-col"}>
                    <h1 className={"text-center"}>Wpisz tekst: </h1>
                    <label form={"text"}>
                    <textarea id={"text"}
                              className={"border-4 w-full h-full overflow-hidden p-2 text-justify comic-sans resize-none"}
                              rows={8}
                              value={text}
                              onChange={textSetter}
                    />
                        <p className={"mr-5 text-right"}>
                            {text.length}/{maxChars}
                        </p>
                    </label>
                </div>
                <div className={"w-1/2 border-4 p-2"}>
                    <h1 className={"text-center"}>Wybierz transformację: </h1>
                    <div>
                        {transformations.map(trans => (
                            <Button click={AddTransformation} type={trans} key={Math.random()}/>
                        ))}
                    </div>
                </div>
            </div>
            <h2 className={"mt-4 mx-12"}>Wybrane transformacje:</h2>
            <div className={"border-4 mt-4 mx-12 h-40 p-2"}>
                <div>
                    {Object.keys(chosenTranformations).map((key, index) => (
                        <Button click={RemoveTransformation} id={key} key={key} type={chosenTranformations[key]} />
                    ))}
                </div>

            </div>
            <div className={"right mt-4 mx-12 flex flex-row"}>
                <Button click={sendTextTransformRequest} type={"Wyślij"}/>
                {textAfterTransformation.length>0 && <p>{textAfterTransformation}</p>}
            </div>
        </div>
    )
}
