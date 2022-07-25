import './App.css';
import {Container, Nav, Navbar} from 'react-bootstrap';
import {Route, Routes, useNavigate} from "react-router-dom";
import Board from "./pages/Board";

function App() {

    let navi = useNavigate();

    return (
        <div className="App">
            <Navbar bg="light" variant="light">
                <Container>
                    <Navbar.Brand href="/">Recody</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link onClick={() => {
                            navi('/')
                        }}>Recody</Nav.Link>
                        <Nav.Link onClick={() => {
                            navi('/board')
                        }}>Board</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>

            <Routes>
                <Route path="/" element={
                    <div>Hello World !</div>
                }/>
                <Route path="/Board" element={<Board/>}/>
            </Routes>
        </div>
    );
}

export default App;
