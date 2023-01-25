import React from "react";

import {Link} from 'react-router-dom';
import {
    Card,
    Table,
    Image,
    ButtonGroup,
    Button,
    InputGroup,
    FormControl,
  } from "react-bootstrap";
  import axios from "axios";


class Customer extends React.Component{


    constructor(props){
        super(props);
        this.state={
            products:[]
        }
    }

    componentDidMount(){
       
        axios.get("http://localhost:9000/api/customer/getProducts").then(Response =>(Response.data)) .then((data)=>{this.setState({products:data})});
          
   
    }

    
    render(){
        return(
           
            <div className="table">
        <Card className={"border border-dark bg-b=dark text-white"}>
        <Card.Header className={"heading"}>Payment Details</Card.Header>
         <Card.Body>
       
        {
        this.state.products.map((
                    product) => (
<div class="col-xs-12 col-sm-6 col-md-6 col-lg-4"
    data-aos="zoom-in-down">
    <div class="card">

        <div class="card-content" key={product.id}>
            <p id="productName" name="productName">
            <h3 class="card-title">{product.productName}</h3>

            </p>
            <p >
            <h4 class="card-title">{product.productDescription}</h4>

            </p>
           
           
        </div>
        <div class="card-read-more">
          
           
           <button type="submit" onClick={`/productdetails/${product.productName}`}>ADD TO CART</button>
           

        </div>
    </div>
</div>


                    ))
        }
       </Card.Body>
       </Card>
       </div>

        );
    
}
}
export default Customer;