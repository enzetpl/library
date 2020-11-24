import React, {Component} from 'react';
import {Container, Button, Table} from 'reactstrap';
import {Link} from 'react-router-dom';
import axios from 'axios';
import authHeader from '../services/auth-header';
import authService from '../services/auth-service';

const API_URL = 'http://localhost:8080/api/'

class HireForm extends Component {

    emptyHire = {
        cardNumber: '',
        address: '',

    }
    constructor(props) {
        super(props);
        this.state = {
            hire: [],
            isLoading: true
        }
    }
    componentDidMount() {

        this.setState({isLoading: true});
        this.setState({
            hire: axios.get(API_URL+"hires", {headers: authHeader()}).hires
        })

          
    }

    render() {
        const hire = this.state.hire;
        if(!localStorage.getItem('user')) {
            return(
                <div>
                    You must be logged in to hire book!
                    <Button tag={Link} to="/login">LOGIN</Button>
                </div>
            )
        }
        return(
            <div>
                {hire}
            </div>
        )
    }
}

export default HireForm;