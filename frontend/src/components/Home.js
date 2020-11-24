import React, {Component} from 'react';
import {Container, Button} from 'reactstrap';
import {Link} from 'react-router-dom';

class Home extends Component {
    render() {
        return (
            <div>
                <Container fluid>
                    <br/><br/>
                    <Button color="dark" tag={Link} to="/books">See avalible books</Button>
                </Container>
            </div>
        )
    }
}

export default Home;