import React from 'react';
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
import {  useParams } from "react-router";

function withParams(Component) {
  return props => <Component {...props} params={useParams()} />;
}

class AddProducts extends React.Component{

    constructor(props){
      super(props);
    this.state= this.initiaLSTATE;
    this.state={};
}
  initiaLSTATE={
    
    productName:"",
    price:"",
    weight:"",
    productDescription:"",
    
    quantity:"",
    
};

  handlesubmit=(event)=>{

    alert(this.state.productName)
   
  const products={
    productName:this.state.productName,
    price:this.state.price,
    weight:this.state.weight,
    productDescription:this.state.productDescription,
    quantity:this.state.quantity,
    
  }
  let  {id}  = this.props.params;
  const result = axios.post("http://localhost:9000/api/vendor/addProducts/"+id+"?productName="+this.state.productName+"&price="+this.state.price+"&weight="+this.state.weight+"&productDescription="+this.state.productDescription+"&quantity="+this.state.quantity)
  
  .then(response => {
    if(response.data==="Success"){
alert(response.data);
window.location="/manageProducts/"+id;

    }else{
      alert("This item is alredy added")
  }

   

  })
}
    onInputChange=(e)=>{

        this.setState({

            [e.target.name]: e.target.value,

        })

      }

  render() {
  return (
    <React.Fragment>
          <Form >
     {/* <MDBContainer fluid className='bg-dark'>

      <MDBRow className='d-flex justify-content-center align-items-center h-100'>
        <MDBCol> */}

          {/* <MDBCard className='my-8'> */}

            <MDBRow className='g-8'> 

              {/* <MDBCol md='10'> */}
                {/* <MDBCardImage src='https://i5.walmartimages.com/asr/949dc216-3595-4642-83b2-57fe82a62090.a99f70a5b272915ce33912f78800e7dc.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF'  alt="MDBCard image cap" className="img-fluid" fluid/> */}
              {/* &nbsp;
              <img src= 'https://i5.walmartimages.com/asr/949dc216-3595-4642-83b2-57fe82a62090.a99f70a5b272915ce33912f78800e7dc.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF'width={900} height={900} />
              </MDBCol> */}
              <MDBCol md='6'>

                 <MDBCardBody className='text-black d-flex flex-column justify-content-center'> 
                  <h3 className="mb-5 text-uppercase fw-bold">ADD PRODUCTS</h3>

                  <MDBRow>

                    <MDBCol md='15'>
                       <MDBInput wrapperClass='mb-5' label='Product Name' size='lg'  id="productName" name="productName" value={this.state.productName} required placeholder="Product name" onChange={this.onInputChange}  /> 


                      
                    </MDBCol>

                    <MDBCol md='12'>
                    <MDBInput type='number' wrapperClass='mb-5' label='Price' size='lg'  id="price" name="price" value={this.state.price} required placeholder="Price" onChange={this.onInputChange}  /> 
                    </MDBCol>

                  </MDBRow>

                  <MDBInput type='number' wrapperClass='mb-5' label='Weight' size='lg'  id="weight" name="weight" value={this.state.weight} required placeholder="Weight" onChange={this.onInputChange}  /> 

                 

                

                  <MDBInput wrapperClass='mb-5' label='Product-Desctiption' size='lg'  id="productDescription" name="productDescription" value={this.state.productDescription} required placeholder="productDescription " onChange={this.onInputChange}  /> 
                  <MDBInput type='number' wrapperClass='mb-5' label='Quantity' size='lg'  id="quantity" name="quantity" value={this.state.quantity} required placeholder="quantity " onChange={this.onInputChange}  /> 
                  <MDBInput type='file' wrapperClass='mb-5' label='Image' size='lg'  id="eimage" name="eimage" value={this.state.eimage} required placeholder="quantity " onChange={this.onInputChange}  /> 

                  <div className="d-flex justify-content-end pt-3">
                    <MDBBtn type="reset" color='light' size='lg'>Reset all</MDBBtn>
                    {/* <MDBBtn type="submit"  className='ms-2' color='warning' size='lg'>Add Products</MDBBtn> */}
                    <MDBBtn type="submit"  onClick={this.handlesubmit} className='ms-2' color='warning' value="Submit and Back to Login" >Add Products</MDBBtn>
                  </div>
                  
               </MDBCardBody> 

              </MDBCol>
             </MDBRow>

          {/* </MDBCard> */}

        {/* </MDBCol>
      </MDBRow>

    </MDBContainer>  */}
    </Form>
    </React.Fragment>
  );
  }
}


export default withParams(AddProducts);