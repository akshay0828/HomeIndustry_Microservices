
import React, { useState, useEffect } from 'react';
import axios from 'axios';


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
    }, []);
function AreaSelection() {
  const areas = ['{orders.area}', 'Area 2', 'Area 3', 'Area 4'];
  
  const handleSelect = (area) => {
    console.log(area);
  }

  return (
    <div>
      <AreaSelector areas={areas} onSelect={handleSelect}/>
    </div>
  );
}
export default AreaSelection;