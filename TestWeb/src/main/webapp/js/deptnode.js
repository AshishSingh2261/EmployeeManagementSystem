const template3 = document.createElement('template');
template3.innerHTML=`
<style> h3{
  border: 1px solid black;
  background-color:lightblue;
  font-size: 20px;
  text-align: center;
  padding: 15px 5px;
  width:70%;
  margin:0;
}

h4{
  border: 1px solid black;
  background-color:lightgreen;
  font-size: 20px;
  text-align: center;
  padding: 15px 5px;
  width:70%;
  margin:0;
}


</style>
<h3></h3>
<h4></h4>
`;



class deptnode extends HTMLElement {
    constructor() {
        super();
        this.attachShadow({mode: 'open'});
        this.shadowRoot.appendChild(template3.content.cloneNode(true));
        this.shadowRoot.querySelector('h3').innerText = this.getAttribute('deptname');
        this.shadowRoot.querySelector('h4').innerText = this.getAttribute('role')+this.getAttribute('name');
    }
}

window.customElements.define('dept-el', deptnode)