// import React, { useState, useEffect } from 'react';
// import NavBar from './NavBar';
// import OrdersComponent from './Orders';


// function SelectArea() {
//   const [options, setOptions] = useState([]);
//   const [selectedOption, setSelectedOption] = useState("");
//   const [orders, setOrders] = useState([]);
//   const [isLoading, setIsLoading] = useState(false);

//   useEffect(() => {
//     fetch('http://localhost:9004/api/delivery/getOrdersAllByArea')
//       .then(response => response.json())
//       .then(data => setOptions(data))
//   }, []);

//   function handleChange(event) {
//     setSelectedOption(event.target.value);
//   }

//   function handleSubmit() {
//     if(!selectedOption) {
//       return alert("Please select an option");
//     }
//     fetch(`http://localhost:9004/api/delivery/getOrdersByArea/625/?address=${selectedOption}`)
//       .then(response => response.json())
//       .then(data => {
//         setOrders(data);
//         setIsLoading(false);
//         console.log(data);
//       })
//   }

//   return (
    
//     <div>
//         <NavBar />
//         <form onSubmit={handleSubmit}>
//       <label>Select an option:</label>
//       <select onChange={handleChange} value={selectedOption}>
//         <option value="">Select an option</option>
//         {options.map((option, index) => (
//           <option key={index} value={option}>{option}</option>
//         ))}
//       </select>
//       <button type="submit">View Orders</button>
//       {isLoading ? <p>Loading...</p> : <OrdersComponent orders={orders} />}
//     </form>
//   </div>
//   );
// }

// export default SelectArea;


import React, { useState, useEffect } from 'react';
import OrdersComponent from './Orders';
import NavBar from './NavBar';

function SelectArea() {
  const [selectedOption, setSelectedOption] = useState("");
  const [orders, setOrders] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [options, setOptions] = useState([]);
  

  useEffect(() => {
        fetch('http://localhost:9004/api/delivery/getOrdersAllByArea')
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
    fetch(`http://localhost:9004/api/delivery/getOrdersByArea/625/?address=${selectedOption}`)
      .then(response => response.json())
      .then(data => {
        setOrders(data);
        setIsLoading(false);
      })
  }

  return (
    <div>

     <NavBar />
   
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
    
  );
}

export default SelectArea;

