
import React from 'react';
import { useEffect, useState } from 'react';

import './EditProfile.css';

import NavBar from './NavigationBar';

import isMounted from 'react';

import setIsMounted from 'react';

import { withRouter, useParams } from "react-router";

import { Link } from 'react-router-dom';

import {
    MDBBtn,
    MDBContainer,
    MDBCard,
    MDBCardBody,
    MDBCardImage,
    MDBRow,
    MDBCol,
    MDBInput,
    MDBRadio,
    MDBSelect
  }
  from 'mdb-react-ui-kit';
  import axios from "axios";
  import { Form } from "react-bootstrap";





function UpdateProfile() {

    const [name, setName] = useState();

    const [email, setEmail] = useState();

    const [username, setUsername] = useState('');

    const [address, setAddress] = useState('');

    const [area, setArea] = useState('');

    const [contact, setContact] = useState('');
    const { id } = useParams();


    const handleSubmit = async (event) => {

        event.preventDefault();

        alert(document.getElementById('name').value);

        try {

           
            const result = axios.post("http://localhost:9000/api/vendor/update/"+id+"?name="+document.getElementById('name').value+"&email=aksay@gmail.com&username=akshay&address=qw&area=jpNagar&contact=123456789");
          

           

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
   
    console.log(id);

    const result=await axios.get("http://localhost:9000/api/vendor/username/"+id);

                                   

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
            {/* <MDBContainer fluid className='bg-dark'> */}
            {/* <MDBRow className='d-flex justify-content-center align-items-center h-100'>
        <MDBCol>

        <MDBCard className='my-5'>

<MDBRow className='g-5'> */}
{/* <MDBCardBody className='text-black d-flex flex-column justify-content-center'> */}
                  <h3 className="mb-5 text-uppercase fw-bold">Update Profile</h3>

        <form onSubmit={handleSubmit} className="edit-profile">
        <MDBRow >
        <MDBCol md='12'>
            <label>
            <br />
            
                Name:

                <input type="text" id="name" defaultValue={users.name}  />
                
               
            </label>
            </MDBCol>
            </MDBRow>
            <br />


            <MDBCol md='12'>
            <label>

                Email:

                <input type="email" id="email" defaultValue={users.email} />

            </label>
            </MDBCol>

            <br/>

            <MDBCol md='12'>
            <label>

                Username:

                <input type="text" id="username" value={users.username}  />
            </label>
            </MDBCol>

            <br />
            <MDBCol md='11'>
            <label>

                Address:

                <textarea id="address"  defaultValue={users.address} />

            </label>
            </MDBCol>

            <br />
            <MDBCol md='12'>
            <label>

                Area:

                <input type="text" id="area" defaultValue={users.area}  />

            </label>
            </MDBCol>
            <br />
            <MDBCol md='12'>
            <label>

                Contact:

                <input type="text" id="contact" defaultValue={users.contact}  />

            </label>
            </MDBCol>
            <br />

           
            <MDBCol md='18'>
            <button type="submit" className='btn btn-primary'>Save</button>
            </MDBCol>
           

           
        
        </form>
        {/* </MDBCardBody> */}
        {/* </MDBRow>
        </MDBCard>
        </MDBCol>
        </MDBRow> */}
        {/* </MDBContainer> */}
        </div>

       

    );

}



export default UpdateProfile;