
import React, { useState, useEffect } from 'react';
import OrdersComponent from './Orders';
import NavBar from './NavigationBar';
import { useParams } from 'react-router-dom';
import './SelectArea.css';

function SelectArea() {
  const [selectedOption, setSelectedOption] = useState("");
  const [orders, setOrders] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [options, setOptions] = useState([]);
  
const {id}=useParams();

  useEffect(() => {
        fetch('http://localhost:9004/api/delivery/getOrdersAllByArea/PLACED')
          .then(response => response.json())
          .then(data => setOptions(data))
      }, []);

  function handleChange(event) {
    setSelectedOption(event.target.value);
  }
  function handleAccept(orderId) {
    // Make a request to the backend API to update the order's status
    // ...
    // Update the orders state with the updated order
    setOrders(
        orders.map(order => {
            if (order.id === orderId) {
                return {...order, status: "Accepted"}
            }
            return order;
        })
    );
  }

  function handleSubmit(event) {
    event.preventDefault();
    if(!selectedOption) {
      return alert("Please select an option");
    }
    setIsLoading(true);
    fetch(`http://localhost:9004/api/delivery/getOrdersByAreaAndStatus/`+id+`/?address='${selectedOption}'&status='PLACED'`)
    
      .then(response => response.json())
      .then(data => {
        setOrders(data);
        setIsLoading(false);
      })
  }

  return (
    <div>
    <NavBar />
    <div className='center_option'>
     
   <div className='card_adj'>
   <h1 className='adj_head'>Select The Area According To Your Location</h1>
   <div className="card">
   
    <form onSubmit={handleSubmit}>
    
      <label>Select an option:</label>
      <select onChange={handleChange} value={selectedOption}>
        <option value="">Select an option</option>
        {options.map((option, index) => (
          <option key={index} value={option}>{option}</option>
        ))}
      </select>
      <button type="submit" >Get Orders</button>
      {isLoading ? <p>Loading...</p> : <OrdersComponent orders={orders} />}
    </form>
    </div>
    </div>
    </div>
    </div>
    
  );
}

export default SelectArea;

 

