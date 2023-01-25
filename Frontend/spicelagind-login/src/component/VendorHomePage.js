import React from "react";
import {Card,Button} from 'react-bootstrap';
import CardHeader from "react-bootstrap/esm/CardHeader";
import { Link } from "react-router-dom";
import axios from 'axios';
import Orders from "./AddProducts";
import {  useParams } from "react-router";




function VendorHomePage() {
  
  const { id } = useParams();

       
        return(
         <p className="admin">
            Welcome Admin
           
        <br/>
            <div class="container-fluid">
			<div class="row justify-content-center">
            <div>
            &nbsp;
            <Card className="header">
      <Card.Body>
       <p class="text-dark">ADD PRODUCTS</p>
       
        <br/>
        {/* <Card.Link href="#">Vendor</Card.Link>
        <Card.Link href="#">Delivery</Card.Link> */}

<Link to= {`/addProducts/${id}`}>ADD</Link>

       
       
      </Card.Body>
       
    </Card>
    </div>
&nbsp;
    

   
    <div >
            <Card className="header">
      <Card.Body>
        <p class="text-dark">MANAGE PRODUCTS</p>
      
        <br/>
        {/* <Card.Link href="#">View</Card.Link> */}
        <Link to= {`/manageProducts/${id}`}>Go</Link>
      </Card.Body>
    </Card>
    </div>
    &nbsp;
    <div >
            <Card className="header">
      <Card.Body>
        <p class="text-dark">UPDATE PROFILE</p>
       
        <br/>
         

        {/* <Card.Link href="/Orders">Orders</Card.Link> */}
        <Link to= {`/updateProfile/${id}`}>Click</Link>
       
      </Card.Body>
    </Card>
    </div>
    </div>
    </div>
    </p>
        );
    }
export default VendorHomePage;


