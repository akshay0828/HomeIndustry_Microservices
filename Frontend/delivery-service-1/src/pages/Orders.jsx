import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Orders() {
    const [orders, setOrders] = useState([]);

    useEffect(() => {
        const fetchOrders = async () => {
            try {
                const response = await axios.get("http://localhost:9004/api/delivery/getAllOrders/625");
                setOrders(response.data);
                console.log(response.data);
            } catch (error) {
                console.log(error);
            }
        }
        fetchOrders();
    }, []); // the empty dependency array makes the effect only run on first render

    return (
        <div>
            {orders.map((order, index) => (
                <div key={index}>
                    <p>Order ID: {order.id}</p>
                    <p>Customer Name: {order.customerName}</p>
                    <p>Order Date: {order.orderDate}</p>
                </div>
            ))}
        </div>
    );
}

export default Orders;
