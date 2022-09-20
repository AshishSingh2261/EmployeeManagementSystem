const template1 = document.createElement('template');
template1.innerHTML=`
<style> h3{
  border: 1px solid black;
  background-color:blue;
  font-size: 20px;
  text-align: center;
  padding: 15px 0px;
  width:70%;
}</style>
<h3></h3>
`;

class boxEl extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({mode: 'open'});
        this.shadowRoot.appendChild(template1.content.cloneNode(true));
        this.shadowRoot.querySelector('h3').innerText = this.getAttribute('name');
    }
}

window.customElements.define('box-el', boxEl)

