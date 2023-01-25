import React from "react";
import {Navbar,Nav} from 'react-bootstrap';
import { Link } from "react-router-dom";
import {  useParams } from "react-router";

  
 function NavigationBar() {
    let { id } = useParams();

    
        return(
            <Navbar  bg="dark" variant="dark">
                <Navbar.Brand href="/" className="logout">Logout</Navbar.Brand>
                
                </Navbar>
    
        );
    }
export default NavigationBar;

