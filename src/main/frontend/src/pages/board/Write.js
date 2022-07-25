import React from "react";
import {Button, Form} from "react-bootstrap";
import axios from "axios";
import {useNavigate} from "react-router-dom";

const Write = () => {

    let navi = useNavigate();

    const handleSubmit = (event) => {
        event.preventDefault();
        axios.post('http://localhost:8080/api/board/createBoard', {
            'userId': 'seoma',
            'cateId': '12345678',
            'title': event.target.title.value,
            'content': event.target.content.value
        })
            .then((res) => {
                navi('/board/list');
            })
            .catch(error => console.log(error))
    }

    return (
        <div>
            <h3>글쓰기</h3>
            <Form onSubmit={handleSubmit}>
                <Form.Group className="mb-3" controlId="title">
                    <Form.Control type="text" placeholder="title"/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="content">
                    <Form.Control as="textarea" rows={10}/>
                </Form.Group>
                <Button variant="primary" className="float-start" type="submit">
                    작성
                </Button>
            </Form>
        </div>
    )
}

export default Write;