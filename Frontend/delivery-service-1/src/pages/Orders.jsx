import React from 'react';
import './Orders.css';
import axios from 'axios';
import { Link, useHistory } from 'react-router-dom';

function OrdersComponent({ orders }) {

 
  function handleClick() {
    axios.put('http://localhost:9004/api/delivery/updateStatus/3', {
      status: 'ACCEPTE'
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
          <p className='space'>User Id -{order.user_id}</p>
          <p className='space'>Area -{order.area}</p>
          <Link to={'/orderDetails'}>
          <button onClick={handleClick} className='space_btn'>Accept Order</button></Link>
        </div>
      ))}
    </div>
  );
}

export default OrdersComponent;
