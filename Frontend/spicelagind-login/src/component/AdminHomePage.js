import React from "react";
import {Card,Button} from 'react-bootstrap';
import CardHeader from "react-bootstrap/esm/CardHeader";
import { Link } from "react-router-dom";
import axios from 'axios';
import {Navbar,Nav} from 'react-bootstrap';




class AdminHomePage extends React.Component{
    render(){
       
        return(
          <p>
                <p className="App1">
                <Navbar  bg="dark" variant="dark">
                <Navbar.Brand href="/" className="logout">Logout</Navbar.Brand>
                </Navbar>
                <header className="App-header1">
             
         <p className="admin">
            Welcome Admin</p>
        <br/>    <br/>    <br/>    <br/>    
            <div class="container-fluid">
			<div class="row justify-content-center">
            <div class="col-md-6 pt-7">
            <Card className="header">
      <Card.Body>
        <Card.Title className="title">Manage the users</Card.Title>
       
        <br/>
        
      

<button> <Link to="/VendorApproval">Vendor</Link></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<button>   <Link to="/DeliveryApproval">Delivery</Link></button>

       
       
      </Card.Body>
    </Card>
    </div>

   
   
    <div class="col-md-6 pt-7">
            <Card className="header">
      <Card.Body>
        <Card.Title className="title">List of Orders</Card.Title>
      
        <br/>
      
        <button> <Link to="/viewOrders">View</Link></button>
      </Card.Body>
    </Card>
    </div>
    </div>
    </div>
    </header>
    </p>
    </p>
        );
    }
}export default AdminHomePage;


