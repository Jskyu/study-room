import React from "react";
import './App.css';
import {Container, Nav, Navbar} from 'react-bootstrap';
import {Route, Routes, useNavigate} from "react-router-dom";
import Board from "./pages/board/Board";
import Write from "./pages/board/Write";

function App() {

    let navi = useNavigate();

    return (
        <div className="App">
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand href="/">Recody</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link onClick={() => { navi('/')}}>Recody</Nav.Link>
                        <Nav.Link onClick={() => { navi('/board/list') }}>Board</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
            <div className="container" style={{marginBlock: '20px'}}>
                <Routes>
                    <Route path="/" element={
                        <div>Hello World !</div>
                    }/>
                    <Route exact="/board">
                        <Route path={"/board/list"} element={<Board/>} />
                        <Route path={"/board/write"} element={<Write/>} />
                    </Route>
                </Routes>
            </div>
        </div>
    );
}

export default App;
