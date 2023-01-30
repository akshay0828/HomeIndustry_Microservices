
import React, { useState, useEffect } from 'react';
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
  import { useParams } from "react-router";
import { Link } from "react-router-dom";

  function withParams(Component) {
     return props => <Component {...props} params={useParams()} />;
    }
  class Cartline extends React.Component{
  
   
    constructor(props){
        super(props);
       
        this.state={
           carts:[],
          
           data: []
        };

    } 
        componentDidMount(){
       
          let {id} = this.props.params;
        
          axios.get("http://localhost:9000/api/customer/CartDetails/"+id).then(Response =>(Response.data)) .then((data)=>{this.setState({carts:data})

          axios.post("http://localhost:9000/api/customer/totalAmount/"+id).then(res => {
          this.setState({ data: res.data });
        })
        .catch(error => {
          console.log(error);
        });
          
        });
      }
     
        handleadd(cartid){
       
          // alert(cartid)
        
          
          axios.post("http://localhost:9000/api/customer/IncreaseBYOne/"+cartid);
          window.location.reload();

        
       
      }
     
      handlesub(cartid){
       
        alert(cartid)
      
        
        axios.post("http://localhost:9000/api/customer/decreaseBYOne/"+cartid);
        window.location.reload();

      
     
    }
    //  handletotal(event){
    //   let {id} = this.props.params;
        
    // alert("hi")
      
      
    //   alert(result.data)
      
     
    //  }
      // window.location.reload();

    
   

    // handlepayment(event){
    
  
    //   event.preventDefault()
    //       let {id} = this.props.params;
    //       window.location="/customer/"+id+"payment";
  
  
    //  } 
    render(){
      let {id} = this.props.params;
      return(
        <form>
        <div>
        <h1>Cartline</h1>
        <table>
          <thead>
        <tr>
          <th>productName</th>
          <th>price</th>
          <th>quantity</th>
        </tr>
        </thead>
        <tbody id="product">
      
        {
        this.state.carts.map((carts) => (<tr  key={carts.id}> 
        <td>{carts.productName}</td> 
        <td>{carts.price}</td>
        <td>{carts.quantity}</td>
        <button type="submit" onClick={()=>this.handleadd(carts.id)}>+</button>
        &nbsp;&nbsp;<button type="submit" onClick={()=>this.handlesub(carts.id)}>-</button>
        </tr>
     )
        )

    }
    <tr><td>
  TotalAmount</td>{this.state.data}<td></td>
  </tr>
        </tbody>
        </table>
       
        <Link to={"/customer/"+id+"/payment"}>Payment</Link>
        {/* <button type="submit" onClick={this.handlepayment}>Payment</button> */}
        </div>
        </form>
      );
  }
    
}
     

export default withParams(Cartline);