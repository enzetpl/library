import React, {Component} from 'react';
import {Container, Button, Table} from 'reactstrap';
import {Link} from 'react-router-dom';

function CopiesListButton(props) {
    const copies = props.copies;
    const id = props.id;
    if(copies > 0) {
        return (
            <Button size="sm" color="primary" tag={Link} to={"/books/"+id+"/copies"}>See avalible copies</Button>
        )
    }
    return(<span>Not any copies in library</span>)
}

class BookList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            isLoading: true
        }
    }
    componentDidMount() {
        this.setState({isLoading: true});
        console.log('user: '+localStorage.getItem('user'));

        fetch("http://localhost:8080/api/books")
            .then(response=>response.json())
            .then(data=>this.setState({
                books: data,
                isLoading: false
            }));
    }

    render() {
        const {books, isLoading} = this.state;

        if(isLoading) {
            return<p>Loading...</p>
        }

        const bookList = books.map(book=> {
            return <tr key={book.id}>
            <td>{book.title}</td>
            <td>{book.authors[0].firstname} {book.authors[0].lastname}</td>
            {/* <td><Button size="sm" color="primary" tag={Link} to={"/books/"+book.id}>See avalible copies</Button></td> */}
            <td><CopiesListButton copies={book.allCopies} id={book.id}/></td>
            </tr>
        
        })
        return(
            <div>
                <Container fluid>
                    <Table>
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>Authors</th>
                            </tr>
                        </thead>
                        <tbody>
                            {bookList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        )
    }
}

export default BookList;