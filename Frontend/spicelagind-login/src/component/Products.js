import React from "react";
import {
    Card,
  
  } from "react-bootstrap";
  import axios from "axios";
  import { useParams } from "react-router";

  function withParams(Component) {
     return props => <Component {...props} params={useParams()} />;
    }
class Products extends React.Component{
    
    constructor(props){
        super(props);
        this.state={
            products:[],
            // quantity:null,
        };
        this.state={
            
        };
        
    }
    
    componentDidMount(){
       
        let {productName} = this.props.params;
      
        axios.get("http://localhost:9003/api/customer/SpecificProduct/"+productName).then(Response =>(Response.data)) .then((data)=>{this.setState({products:data})});
        

    }
    handlesubmit = this.handlesubmit.bind(this);
 
    handlesubmit(event){
        event.preventDefault();
        const user={
           quantity:this.state.quantity,
           
          }
          let {id} = this.props.params;
          let pid=document.getElementById('vendors').value;

          alert(pid);
       const qty=this.state.quantity;
      
       const quantity=11;
alert(quantity);

       if(qty<quantity){
        axios.post("http://localhost:9003/api/customer/AddToCart/"+id+"/"+pid+"/"+qty).then(Response =>(Response.data)) .then((data)=>{this.setState({products:data})});
        window.location="/customer/"+id+"/cartline"
       }
       else{
        alert("Not avaliable");
        window.location.reload();
       }
    }
   
    onInputChange=(e)=>{
        this.setState({
            [e.target.name]: e.target.value,
        })
      }
   
    render(){

        let list=this.state.products && this.state.products.map((product) => 
            <option key={product.id}  value={product.id}  data-product-name={product.quantity}>vendor name:{product.user.name}&nbsp;price&nbsp;:{product.price} &nbsp;Available&nbsp;Quantity&nbsp;:{product.quantity} </option>
        );
       

        // let quan=this.state.products && this.state.products.map((product) => 
        //     <option key={product.id} value={product.quantity}>vendor name:{product.user.name}&nbsp;price&nbsp;:{product.price} &nbsp;Available&nbsp;Quantity&nbsp;:{product.quantity  } </option>
        // );
        return(
            
            <form>
        <div className="table">
        <Card className={"border border-dark bg-b=dark text-white"}>
       
            
       <h2>Choose Your Vendor</h2>
        <select id="vendors" name="vendors">
        {list}

          </select>
     <br></br>
          <label for="quantity">Quantity</label><br></br>
        
     
          <input type="text" required id="quantity" name="quantity" value={this.state.quantity} placeholder="Enter Quantity"  title="Password must be between 3-10 characters and type only valid characters!!" onChange={this.onInputChange}/>
          <button  onClick={this.handlesubmit} className='submit'>Add To Cart</button>    
            
         
            </Card>
            </div>
            </form>
        );
}
}
export default withParams(Products);
