import React, {useEffect, useState} from "react";
import axios from "axios";
import {useParams} from "react-router-dom";

const View = () => {

    let { id } = useParams();
    let [board, setBoard] = useState({});

    useEffect(() => {

        axios.get('http://localhost:8080/api/board/getBoard/' + id)
            .catch(error => console.log(error))
            .then((res) => {
                setBoard(res.data.data);
            })
    }, []);

    return (
        <div>
            <h3>{board.title}</h3>
            <p>
                {board.content}
            </p>
        </div>
    )
}

export default View;