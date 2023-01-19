const TransactionTableRow = (transaction) => {
    return (
        <tr key={transaction.id}>
            <td>{transaction.id}</td><td>{transaction.orderId}</td><td>{transaction.date}</td><td>{transaction.country}</td><td>{transaction.currency}</td><td>{transaction.amount}</td>
        </tr>
    );
};

export default TransactionTableRow;
