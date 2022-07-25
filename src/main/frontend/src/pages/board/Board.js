import React, {useEffect, useState} from "react";
import {Button, Table} from "react-bootstrap";
import axios from "axios";

const Board = () => {

    let [boards, setBoards] = useState([])

    useEffect(() => {
        axios.get('http://localhost:8080/api/board/getBoardList')
            .catch(error => console.log(error))
            .then((res) => {
                let data = [...res.data.data];
                setBoards(data);
                console.log(boards);
            })
    }, []);

    return (
        <div>
            <div>
                <Button variant='outline-primary' className="float-sm-end" href={"/board/write"}>글쓰기</Button>
            </div>
            <Table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>글쓴시간</th>
                    </tr>
                </thead>
                <tbody>
                {
                    boards.length > 0 ? boards.map((item, index) => {
                            return(
                                <tr key={index} >
                                    <td>{item.id}</td>
                                    <td>{item.title}</td>
                                    <td>{item.userNick}</td>
                                    <td>{item.regDate}</td>
                                </tr>
                            )
                        }) : null
                }
                </tbody>
            </Table>
        </div>
    )
}

const BoardTable = ({boards}) => {
    return (
        // <tbody>
        //     {boards.map((item) => {
        //         return (
        //             <tr key={item.id}>
        //                 <td>{item.id}</td>
        //                 <td>{item.title}</td>
        //                 <td>{item.userId}</td>
        //                 <td>{item.id}</td>
        //             </tr>
        //         )
        //     }
        // )}
        // </tbody>
        <tbody>
        {boards.map((item, index) => {
            return(
                <tr key={index} >
                    <td>{item.id}</td>
                    <td>{item.title}</td>
                    <td>{item.userId}</td>
                    <td>{item.id}</td>
                </tr>
            )
        })
        }
        </tbody>
    );
}

export default Board;