import React, {Component} from 'react';
import {Container, Button, Table} from 'reactstrap';
import {Link} from 'react-router-dom';

function HireButton(props) {
    const isAvalible = !props.isHired;
    const copyId  =props.copyId;
    const bookId = props.bookId;
    if(isAvalible) {
        return (
            <Button color="success" tag={Link} to={"/books/"+bookId+"/copies/"+copyId}>hire</Button>
        )
    }
    return(<span>Not avalible</span>)
}

class CopyList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            bookTitle: "null",
            copies: [],
            isLoading: true
        }
    }
    componentDidMount() {
        this.setState({isLoading: true});

        fetch(`http://localhost:8080/api/books/${this.props.match.params.id}/copies`)
            .then(response=>response.json())
            .then(data=>this.setState({
                copies: data,
                bookTitle: data[0].bookTitle,
                isLoading: false
            }));
    };
     
    render() {
        const {copies, isLoading, bookTitle} = this.state;
        if(isLoading) {
            return<p>Loading...</p>
        }
        
        const copyList = copies.map(copy=> {
            
            return <tr key={copy.id}>
            <td>{copy.releaseDate}</td>
            <td>{(copy.id)}</td>
            <td><HireButton isHired={copy.hire} copyId={copy.id} bookId={this.props.match.params.id}></HireButton></td>
            {/* <td>{book.authors[0].firstname} {book.authors[0].lastname}</td> */}
            {/* <td><Button size="sm" color="primary" tag={Link} to={"/books/"+book.id}>See avalible copies</Button></td> */}
            </tr>
        
        });
        return(
            <div>
            <br></br>
                <Container fluid>
                <h2 style={{display: 'flex',  justifyContent:'center', alignItems:'center'}} >{bookTitle}</h2>
                <br></br>
                    <Table>
                        <thead>
                            <tr>
                                <th>Release Year</th>
                                <th>Id</th>
                                <th>is avalible</th>
                            </tr>
                        </thead>
                        <tbody>
                            {copyList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        )
    }
}



export default CopyList;