
import axios from 'axios';
import { useEffect, useState } from 'react';
import './EditProfile.css';
import NavBar from './NavBar';
import isMounted from 'react';
import setIsMounted from 'react';

function EditProfile() {
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [address, setAddress] = useState('');
    const [area, setArea] = useState('');
    const [contact, setContact] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        // Code to handle submitting the form, such as making an API call to update the user's profile information
        console.log(name, email, username, address, area, contact);
    }
    const [users,setUsers]=useState(false);
  useEffect( () => {
    if(!users) {
        setUsers(true);
        // call the api here
        loadUsers();
    }
   
  });
  const loadUsers=async () => {
    const result=await axios.get("http://localhost:9004/api/delivery/getUserData/1");
                                   
    setUsers(result.data);
    console.log(result.data);
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
                <input type="text" defaultValue={users.name} onChange={e => setName(e.target.value)} />
            </label>
            <br />
            <label>
                Email:
                <input type="email" defaultValue={users.email} onChange={e => setEmail(e.target.value)} />
            </label>
            <br />
            <label>
                Username:
                <input type="text" defaultValue={users.username} onChange={e => setUsername(e.target.value)} />
            </label>
            <br />
            <label>
                Address:
                <textarea defaultValue={users.address} onChange={e => setAddress(e.target.value)} />
            </label>
            <br />
            <label>
                Area:
                <input type="text" defaultValue={users.area} onChange={e => setArea(e.target.value)} />
            </label>
            <br />
            <label>
                Contact:
                <input type="text" defaultValue={users.contact} onChange={e => setContact(e.target.value)} />
            </label>
            <br />
            <button type="submit">Save</button>
            
        </form>
        </div>
        
    );
}

export default EditProfile;
