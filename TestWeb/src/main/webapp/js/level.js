const template2 = document.createElement('template');
template2.innerHTML=`
<style> 
h3{
  border: 1px solid black;
  background-color:red;
  font-size: 20px;
  text-align: center;
  padding: 15px 0px;
  width:70%;
}
</style>
<h3></h3>
`;




class level extends HTMLElement {
    constructor() {
        super();
        
        this.attachShadow({mode: 'open'});
        this.shadowRoot.appendChild(template2.content.cloneNode(true));
        this.shadowRoot.querySelector('h3').innerText = "Level : "+this.getAttribute('num');
    }
}


window.customElements.define('level-no', level)/**
 * 
 */