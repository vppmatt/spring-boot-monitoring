import {Link} from "react-router-dom";

const Menu = () => {

    return (
        <ul className="nav">
            <li><Link to="/find">Find a transaction</Link></li>
            <li><Link to="/add">New transaction</Link></li>
            <li><a href="http://localhost:8080/swagger-ui.html" target="_blank">Swagger</a></li>}
        </ul>
    );
}

export default Menu;
