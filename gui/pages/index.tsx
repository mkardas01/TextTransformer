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
        <div className={" min-h-screen w-screen pb-14"} id={"background"}>
            <header
                className={"mx-12 text-4xl text-white sticky pl-6 py-4 font-bold "} id={"navbar"}>
                TextTransformer
            </header>
            <div className="flex flex-col    mt-8 mx-12 gap-12 min-h-80 h-fit md:flex-row">
                <div className={"w-full flex flex-col card py-10 px-8 md:w-1/2"}>
                    <h1 className={"text-white text-left pb-4 font-bold px-2"}>Wpisz tekst: </h1>
                    <label form={"text"}>
                    <textarea id={"text"}
                              className={"border-2 w-full h-full overflow-hidden p-2 px-4 text-justify resize-none overflow-y-auto"}
                              rows={8}
                              value={text}
                              onChange={textSetter}
                    />
                        <p className={"mr-5 text-right"}>
                            {text.length}/{maxChars}
                        </p>
                    </label>
                </div>
                <div className={"w-full  card py-10 px-8 md:w-1/2"} >
                    <h1 className={"text-white text-left pb-4 pl-4 font-bold px-2"}>Wybierz transformację: </h1>
                    <div className={"w-full h-118 p-2"}>
                        {transformations.map(trans => (
                            <Button click={AddTransformation} type={trans} key={Math.random()}/>
                        ))}
                    </div>
                </div>
            </div>

            <div className={"mx-12 mt-14"}>
                <div className={"mt-4 card p-8 min-h-40 h-auto"}>
                    <h2 className={"text-white mt-4 font-bold mx-2"}>Wybrane transformacje:</h2>
                    <div className={"p-4"}>
                        {Object.keys(chosenTranformations).map((key, index) => (
                            <Button click={RemoveTransformation} id={key} key={key} type={chosenTranformations[key]} />
                        ))}
                    </div>
                    <div className={"flex justify-end mx-6"}>
                        <Button click={sendTextTransformRequest} type={"Wyślij"} className={"mt-4"}/>
                    </div>

                </div>

            </div>

            {textAfterTransformation.length>0 &&
                <div className={"mt-14 mx-12 flex flex-col justify-center items-start space-y-4 p-8 card"}>
                    <h2 className={"text-white font-bold mt-4 px-4"}>Tekst po transformacjach:</h2>
                    <div className={"w-full "}>
                        <p className={"break-all ml-0 px-4 w-full"}>{textAfterTransformation}</p>
                    </div>
                </div>
            }

        </div>
    )
}
