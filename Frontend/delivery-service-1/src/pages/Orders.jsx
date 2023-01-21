import React from 'react';
import './Orders.css';
import { useHistory } from 'react-router-dom';

function OrdersComponent({ orders }) {

  // let history = useHistory();

  // const handleClick = () => {
  //   history.push("/orderDetails/1/2");
  // }

  return (
    <div className='orders'>
      {orders.map((order, index) => (
        <div key={index}>
          <p className='space'>Order - {order.id}</p>
          <p className='space'>User Id -{order.user_id}</p>
          <p className='space'>Area -{order.area}</p>
          <button   className='space_btn'>Accept Order</button>
        </div>
      ))}
    </div>
  );
}

export default OrdersComponent;
