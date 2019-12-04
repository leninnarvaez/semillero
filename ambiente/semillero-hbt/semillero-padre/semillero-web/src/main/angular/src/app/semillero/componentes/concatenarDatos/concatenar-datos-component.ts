import { Component, OnInit } from '@angular/core';


/**
 * @description La clase ConcatenarDatosComponent permite concatenar el nombre y la ciudad de la persona
 * @author Lenin Jose Narvaez Martinez <ljnarvaez@gmail.com>
 */

@Component({
    selector: 'concatenar-datos',
    templateUrl: './concatenar-datos-component.html'    
})
export class ConcatenarDatosComponent implements OnInit {
    
    /**
     * Atributo que muestra el nombre
     */
    public nombre:string = "Lenin Narvaez Martinez";

    /**
     * Atributo que muestra la ciudad
     */
    public ciudad:string = "Cerete";
    
    /**
     * Atributo que concatena nombre + ciudad
     */
    public nombreCiudad:string = this.nombre + " - " + this.ciudad;

    /**
    * @description constructor de la clase ConcatenarDatosComponent
    * @author Lenin Jose Narvaez Martinez <ljnarvaez@gmail.com>
    */

    constructor(){

    }

    ngOnInit(): void {
       
        /**
         * Mensaje por consola
         */
        
        console.log("Mensaje: ", this.nombreCiudad);
    }
}