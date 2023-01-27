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

class DeliveryApproval extends React.Component{


    constructor(props){
        super(props);
        this.state={
            users:[]
        }
    }

    componentDidMount(){
       
        axios.get("http://localhost:9000/api/admin/deliveryApproval").then(Response => Response.data).then((data)=>{this.setState({users:data})});

   
    }
    approve(id){
       
        
        axios.post("http://localhost:9000/api/admin/approval/"+id).then(Response => {
                if(Response.data=="Approved"){
                    alert("approved");
                    window.location.reload();
                   
                }
                
            });
        }

        dissaprove(id) {

           
        
            axios.delete("http://localhost:9000/api/admin/dissapproval/"+id).then(Response => {
                    if(Response.data=="DissApproved"){
                        alert("dissapproved");
                        window.location.reload();
                      
                    }
                    
                });
    
            
        }

    
    render(){
        return(
            <div className="table">
         <Card className={"border border-dark bg-b=dark text-white"}>
        <Card.Header className={"heading"}>Delivery Details</Card.Header>
         <Card.Body>
        <Table bordered hover striped variant="dark">
          <thead>
          <tr>
              <th>Name</th>
              <th>Contact_No</th>
              <th>Email</th>
              <th>Enabled</th>
             
            </tr>
           
          </thead>
           <tbody> 
            {
                this.state.users.map((
                    users) => (
                    <tr key={users.id}>
                        <td>{users.name}</td>
                    <td>{users.contact}</td>
             <td>{users.email}</td>
             &nbsp;<button className="btn third"  onClick={()=>this.approve(users.id)}><td>Approve</td></button>&nbsp;&nbsp;
             <button className="btn third" onClick={()=>this.dissaprove(users.id)}><td>Dissapprove</td></button>&nbsp;
             

                    </tr>
                     ) )
            }
        
            
           </tbody> 
        </Table>
        </Card.Body>
       </Card> 
       </div>


        );
    
}
}
export default DeliveryApproval;