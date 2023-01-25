import React from "react";

import {Card} from 'react-bootstrap';


import { Link } from "react-router-dom";



class AdminHomePage extends React.Component{

    render(){

       

        return(

            <p>

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

        <Card.Title className="title">Payment Details</Card.Title>

     

        <br/>

     

        <button> <Link to="/Payment">View</Link></button>

      </Card.Body>

    </Card>

    </div>

    </div>

    </div>

    </p>

        );

    }

}export default AdminHomePage;