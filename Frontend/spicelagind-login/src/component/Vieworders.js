import React from "react";

// import {Link} from 'react-router-dom';

// import {Form,Button} from "react-bootstrap";

// import AdminHomePage from "./AdminHomePage";
import {
    Card,
    Table, } from "react-bootstrap";
import axios from "axios";

class Vieworders extends React.Component{


    constructor(props){
        super(props);
        this.state={
            orders:[]
        }
    }

    componentDidMount(){
       
        let a=axios.get("http://localhost:9000/api/admin/orders").then(Response => Response.data).then((data)=>{this.setState({orders:data})});
       
   
    }

    
    render(){
        return(
            <div className="table">
        <Card className={"border border-dark bg-b=dark text-white"}>
        <Card.Header className={"heading"}>Orders And Payment Details</Card.Header>
         <Card.Body>
        <Table bordered hover striped variant="dark">
          <thead>
            <tr>
              <th>Area</th>
              <th>Cart</th>
              <th>Order_Date</th>
              <th>Status</th>
              <th>User_ID</th> 
              <th>Transactin_Id</th> 
            </tr>
           
          </thead>
          <tbody>
            {
                this.state.orders.map((
                    order) => (
                    <tr key={order.id}>
                        <td>{order.area}</td>
                    <td>{order.cart}</td>
             <td>{order.orderDate}</td>
             <td>{order.status}</td>
             <td>{order.userId}</td>
             <td>{order.payment.tranzactinId}</td>
      
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
export default Vieworders;







// import React from "react";

// // import {Link} from 'react-router-dom';

// // import {Form,Button} from "react-bootstrap";

// // import AdminHomePage from "./AdminHomePage";
// // import AdminHomePage from "./AdminHomePage";
// import {
//     Card,
//     Table, } from "react-bootstrap";
// import axios from "axios";

// class Vieworders extends React.Component{


//     constructor(props){
//         super(props);
//         this.state={
//             orders:[]
//         }
//     }

//     componentDidMount(){
       
//         axios.get("http://localhost:9000/api/admin/orders").then(Response => Response.data).then((data)=>{this.setState({orders:data})});

   
//     }

    
//     render(){
//         return(
//             <div className="table">
//         <Card className={"border border-dark bg-b=dark text-dark"}>
//         <Card.Header className={"heading"}>Orders And Payment Details</Card.Header>
//          <Card.Body>
//         <Table bordered hover striped variant="dark">
//           <thead>
//             <tr>
//               <th>Area</th>
//               <th>Cart</th>
//               <th>Order_Date</th>
//               <th>Status</th>
//               <th>User_ID</th> 
//               <th>Transactin_Id</th> 
//             </tr>
           
//           </thead>
//           <tbody>
//             {
//                 this.state.orders.map((
//                     order) => (
//                     <tr key={order.id}>
//                         <td>{order.area}</td>
//                     <td>{order.cart}</td>
//              <td>{order.orderDate}</td>
//              <td>{order.status}</td>
//              <td>{order.userId}</td>
//              <td>{order.payment.tranzactinId}</td>
      
//                     </tr>
//                      ) )
//             }
        
            
//            </tbody>
//         </Table>
//        </Card.Body>
//        </Card>
//        </div>


//         );
    
// }
// }
// export default Vieworders;