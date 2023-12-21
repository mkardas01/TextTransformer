import React from 'react';

const Button = (props) => {
    return (
        <button onClick={props.click} className={"py-2 px-4 bg-fuchsia-400 rounded m-2 hover:bg-fuchsia-800 hover:text-white"} value={props.type} id={props.id}>
            {props.type}
        </button>
    );
};

export default Button;