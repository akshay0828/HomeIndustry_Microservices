import React from "react";

import {Link} from 'react-router-dom';
import {
    Card,
  } from "react-bootstrap";
  import axios from "axios";
  import { useParams } from "react-router";
  
  function withParams(Component) {
    return props => <Component {...props} params={useParams()} />;
   }

class Customer extends React.Component{


    constructor(props){
        super(props);
        this.state={
            products:[]
        }
    }

    componentDidMount(){
       
        axios.get("http://localhost:9003/api/customer/getProducts").then(Response =>(Response.data)) .then((data)=>{this.setState({products:data})});
          
   
    }
    handlesubmit(productName){
        let {id}=this.props.params;
        window.location="/customer/"+id+"/productdetails/"+productName;
    }
    
    render(){
        return(
           
            <div className="table">
        <Card className={"border border-dark bg-b=dark text-white"}>
        <Card.Header className={"heading"}>Product Details</Card.Header>
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
          
           
           <button type="submit" onClick={()=>this.handlesubmit(product.productName)}>View Product Details</button>
           

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
export default withParams(Customer);