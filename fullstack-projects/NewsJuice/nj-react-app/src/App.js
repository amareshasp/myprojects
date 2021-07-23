import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
 import {Tabs, Tab, Modal, Row, Button, Col, Form, Card, Container} from "react-bootstrap";
 import Home from "./components/Home/Home";
 import Profile from "./components/Profile/Profile";
 
function App() {
  return (
 <Container>
                 <Row>
                     <Col>
                         <Tabs defaultActiveKey="Home" 
                               id="controlled-tab-example">
                             <Tab eventKey="home" title="Home">
                             <Home />
                             </Tab>
                             <Tab eventKey="profile" title="Profile">
                                 <Profile />
                             </Tab>
                             <Tab eventKey="contact" title="Contact" disabled>
                              
                             </Tab>
                         </Tabs>
                     </Col>
                 </Row>
                 <Row>
                   Hello
                 </Row>
             </Container>
  );
}

export default App;
