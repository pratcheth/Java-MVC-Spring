/*
        <tr>
            <td>Relentless</td>
            <td>PADS</td>
            <td>25</td>
            <td>22</td>
            <td>0</td>
            <td>60</td>
            <td>
                <form action="/items/merchant/Relentless" method="post">
                <button class="btn btn-info">Buy</button>
                </form>
            </td>
        </tr>
 */

const URLS = {
    items: '/api/items',
};

const toString = ({id, name, slot, attack, stamina, defence, strength, owned}) => {
    let columns = `
    <td>${name}</td>
    <td>${slot}</td>
    <td>${stamina}</td>
    <td>${strength}</td>
    <td>${attack}</td>
    <td>${defence}</td>
    `;

    columns += owned
        ? `<td></td>`
        : `
        <td>
        <form action = "/items/merchant/${id}" method = "post">
        <button class = "btn btn-info"> Buy </button>
        </form>
        </td>`
    return `<tr>${columns}</tr>`
};

fetch(URLS.items)
    .then(response => response.json())
    .then(items => {
        let result = '';
        items.forEach(item => {
            const itemString = toString(item);
            result += itemString;
        });
        document.getElementById('items-table')
            .innerHTML = result;
    });