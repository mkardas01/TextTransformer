import React from 'react';

const Button = (props) => {
    return (
        <button onClick={props.click} className={`py-2 px-4  rounded m-2 text-black hover:text-white ${props.className}`} value={props.type} id={props.id}>
            {props.type}
        </button>
    );
};


export default Button;