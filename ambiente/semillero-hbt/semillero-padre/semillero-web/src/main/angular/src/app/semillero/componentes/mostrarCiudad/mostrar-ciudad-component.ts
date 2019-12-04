import { Component, OnInit } from '@angular/core';


/**
 * @description La clase MostrarCiudadComponent permite mostrar el nombre y ciudad del participante
 * @author Lenin Jose Narvaez Martinez <ljnarvaez@gmail.com>
 */

@Component({
    selector: 'mostrar-ciudad',
    templateUrl: './mostrar-ciudad-component.html'    
})
export class MostrarCiudadComponent implements OnInit {
    

    /**
    * @description constructor de la clase MostrarCiudadComponent
    * @author Lenin Jose Narvaez Martinez <ljnarvaez@gmail.com>
    */

    constructor(){

    }

    ngOnInit(): void {

        /**
         * Mensaje por consola
         */
        
        console.log("Ingreso al componente MostrarCiudadComponent")
    }
}