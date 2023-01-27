import React from "react";

import {Link} from 'react-router-dom';

import AdminHomePage from "./AdminHomePage";
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
import {  useParams } from "react-router";

function withParams(Component) {
  return props => <Component {...props} params={useParams()} />;
}

class ManageProducts extends React.Component{


    constructor(props){
        super(props);
        this.state={
            products:[]
        }
    }

    componentDidMount(){
      let  {id}  = this.props.params;
       axios.get("http://localhost:9000/api/vendor/productsList/"+id).then(Response => Response.data).then((data)=>{this.setState({products:data})});

    }
  
    handleDelete(id,userid){
    

      alert(id);
      axios.post("http://localhost:9000/api/vendor/deleteProduct/"+id+"/"+userid);
      
      window.location.reload ();

    }


   

    

    
    render(){
        return(
            <div className="table">
        {/* <Card className={"border border-dark bg-b=dark text-white"}> */}
        <Card.Header className={"heading"}>Products Details</Card.Header>
         <Card.Body>
        <Table bordered hover striped variant="dark">
          <thead>
            <tr>
              <th>ProductName</th>
              <th>Price</th>
              <th>Weight</th>
              <th>ProductDescription</th>
              <th>Image</th>
              <th>Quantity</th>
              <th colspan="2">Actions</th> 
            </tr>
           
          </thead>
          <tbody>
            {
                this.state.products.map((products) => (
                    <tr>
                      
                        <td>{products.productName}</td>
                    <td>{products.price}</td>
             <td>{products.weight}</td>
             <td>{products.productDescription}</td>
             <td><img src= 'https://th.bing.com/th/id/R.61d1ce6af28b9b833e122c7d18ccbe51?rik=Q0cmIxKHPpixTg&riu=http%3a%2f%2ffood.fnr.sndimg.com%2fcontent%2fdam%2fimages%2ffood%2funsized%2f2008%2f9%2f30%2f0%2fspice_2.jpg&ehk=O8XnfQXtywWyNGhEWHeSiFeWKLoKS0%2fj7rHAL2HRhoI%3d&risl=&pid=ImgRaw&r=0'width={150} height={100} /></td>
             <td>{products.quantity}</td>
             
              
             
            <td><button><a> <Link to= {`/updateProduct/${products.id}`}>UpdateProduct</Link></a></button></td>
            <td><a><input type="submit" onClick={()=>this.handleDelete(products.id,products.user.id)} className='submit' name="Delete" value="Delete Product"  /></a></td>
                    </tr>
                     ) )
            }
         
            
           </tbody>
        </Table>
       </Card.Body>
       {/* </Card> */}
       </div>


        );
    
}
}
export default withParams(ManageProducts);