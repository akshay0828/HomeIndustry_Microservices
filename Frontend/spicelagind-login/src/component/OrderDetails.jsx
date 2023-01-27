import React from "react";
import { useState, useEffect } from 'react';
import axios from 'axios';
import { Link, useParams } from "react-router-dom";
import NavBar from './NavigationBar';
import './OrderDetails.css';



function OrderDetails() {



  function handleClick() {
    axios.put('http://localhost:9004/api/delivery/updateStatus/711', {
      status: 'DELIVERED'
    })
      .then(response => {
        console.log(response);
      })
      .catch(error => {
        console.log(error);
      });
  }
  const {cus_id}=useParams();
  const {ven_id}=useParams();

  const [data, setData] = useState([]);
  useEffect(() => {
    async function fetchData() {
      const response = await fetch("http://localhost:9004/api/delivery/acceptOrder/1/635");
      const json = await response.json();
      setData(json);
    }

    fetchData();
  }, []);

  return (

    <div>
      <NavBar />
      <div className="center">
        <div className="card">
          <div className="card-title">
            {data}
          </div>
          <div className="card-footer">
          <Link to={`/delivery/${cus_id}`}>
        <button onClick={handleClick} className="delivered-button">Delivered</button></Link>
      </div>
        </div>
      </div>

      {/* <Link to={'/'}>
        <button onClick={handleClick} className="delivered-button">Delivered</button></Link> */}
    </div>


  );
}
export default OrderDetails;

