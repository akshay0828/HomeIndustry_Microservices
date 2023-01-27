import React from 'react';
import './Orders.css';
import axios from 'axios';
import NavBar from './NavigationBar';
import { Link, useHistory, useParams } from 'react-router-dom';

function OrdersComponent({ orders }) {

  const {id}=useParams();
 
  function handleClick() {
    axios.put('http://localhost:9004/api/delivery/updateStatus/711', {
      status: 'ACCEPTED'
    })
    .then(response => {
      console.log(response);
    })
    .catch(error => {
      console.log(error);
    });
  }

  return (
    <div className='orders'>
      
      {orders.map((order, index) => (
        <div key={index}>
          <p className='space'>Order - {order.id}</p>
          <p className='space'>User Id -{order.userId}</p>
          <p className='space'>Area -{order.area}</p>
          
          {/* <Link to={'/orderDetails/625/2'}> */}
            <Link to={`/orderDetails/${id}/${order.userId}`}>
          <button onClick={handleClick} className='space_btn'>Accept Order</button></Link>
        </div>
      ))}
    </div>
  );
}

export default OrdersComponent;
