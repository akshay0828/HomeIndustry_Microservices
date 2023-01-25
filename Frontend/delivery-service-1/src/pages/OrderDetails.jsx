import React from "react";
import { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from "react-router-dom";


function OrderDetails() {

 


  function handleClick() {
    axios.put('http://localhost:9004/api/delivery/updateStatus/3', {
      status: 'DELIVERED'
    })
    .then(response => {
      console.log(response);
    })
    .catch(error => {
      console.log(error);
    });
  }

    const [data, setData] = useState([]);
    useEffect(() => {
        async function fetchData() {
          const response = await fetch('http://localhost:9004/api/delivery/acceptOrder/635/2');
          const json = await response.json();
          setData(json);
        }
        
        fetchData();
      }, []);

     

      


    return (

        <div>
        <h1>{data}</h1>
        
        <Link to={'/'}>
          <button onClick={handleClick} className='space_btn'>Delivered</button></Link>
        </div>
      
      
    );
}
export default OrderDetails;

