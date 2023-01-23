
import axios from 'axios';
import { useEffect, useState } from 'react';
import './EditProfile.css';
import NavBar from './NavBar';
import isMounted from 'react';
import setIsMounted from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';



function EditProfile() {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [address, setAddress] = useState('');
    const [area, setArea] = useState('');
    const [contact, setContact] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
       const dd= document.getElementById('name').value;   
       alert(dd);
        try {
            const res = await axios.put(`http://localhost:9004/api/delivery/UpdateDeliveryPerson/625`, {
                id: 625,
                name: document.getElementById('name').value,
                email: document.getElementById('email').value,
                username: document.getElementById('name').value,
                address: document.getElementById('address').value,
                area: document.getElementById('area').value,
                contact:document.getElementById('contact').value
            });
            
            alert("Profile updated successfully");
            
        } catch (err) {
            console.error(err);
            alert("Error updating profile. Please try again later.");
        }
    }
    const [users,setUsers]=useState(false);
  useEffect( () => {
    if(!users) {
        setUsers(true);
        loadUsers();
    }
   
  });
  const loadUsers=async () => {
    const result=await axios.get("http://localhost:9004/api/delivery/getUserData/625");
                                   
    setUsers(result.data);
    // console.log(result.data);
  }
  const handleReset = () => {
    setName('');
    setEmail('');
    setUsername('');
    setAddress('');
    setArea('');
    setContact('');
}



    return (
        <div>
            <div>
            <NavBar />
            </div>
        <form onSubmit={handleSubmit} className="edit-profile">
            <label>
                Name:
                <input type="text" id= "name" defaultValue={users.name}  />
            </label>
            <br />
            <label>
                Email:
                <input type="email" id= "email" defaultValue={users.email}  />
            </label>
            <br />
            <label>
                Username:
                <input type="text"  value={users.username} onChange={e => setUsername(e.target.value)} />
            </label>
            <br />
            <label>
                Address:
                <textarea defaultValue={users.address} id="address" />
            </label>
            <br />
            <label>
                Area:
                <input type="text" defaultValue={users.area} id="area" />
            </label>
            <br />
            <label>
                Contact:
                <input type="text" defaultValue={users.contact} id="contact" />
            </label>
            <br />
            
            <button type="submit" className='btn btn-primary'>Save</button>
            
            
            
        </form>
        </div>
        
    );
}

export default EditProfile;
