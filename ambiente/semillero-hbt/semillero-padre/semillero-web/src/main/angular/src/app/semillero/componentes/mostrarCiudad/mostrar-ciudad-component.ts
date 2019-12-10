import { Component, OnInit } from '@angular/core';
import { ObjetoComicDTO } from '../../dto/objetoComic.dto';
import { JsonPipe } from '@angular/common';
import { listLazyRoutes } from '@angular/compiler/src/aot/lazy_routes';


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
    * Variable privada que contendra las lista de comic
    */
    private lista  : Array<any> = new Array<any>();

    /**
    * Variable publica que contendra los objetos Comic.
    */
    public objetoComicDTO : ObjetoComicDTO;

    /**
    * Variable publica que contendra el String de tos los comic
    */
    public listaObjeto : string;

    /**
    * Variable publica que mostrara el mensaje de eliminacion del comic
    */
    public mensaje: string;

    /**
    * Variable publica boolean que indicara si se ha eliminado o no un comic
    */
    public verMensaje : boolean;

    /**
    * Variable publica boolean que indica si ya se ha eliminado el comic
    */
    public mensajeError: boolean;
    
    
    /**
    * @description constructor de la clase MostrarCiudadComponent
    * @author Lenin Jose Narvaez Martinez <ljnarvaez@gmail.com>
    */

   myFunction(event){
    console.log("HOla mundo!");
}

    /**
    * @descripcion Constructor de la clase MostrarCiudadComponent
    */

    constructor(){

    }

    ngOnInit(): void {

        /**
        * Inicializacion del atributo verMensaje como false
        */  
        this.verMensaje = false;

        /**
        * Instancia del objeto comi1 a comic5
        */  
        let comic1 = new ObjetoComicDTO();
        let comic2 = new ObjetoComicDTO();
        let comic3 = new ObjetoComicDTO();
        let comic4 = new ObjetoComicDTO();
        let comic5 = new ObjetoComicDTO();

            /**
            * Creacion del objeto comic 1
            */  

            comic1 = {
            id : 123456,
            nombre : "One Piece",
            editorial : "La obeja negra",
            tematica : "UNO",
            numeroPaginas : 1234,
            precio : 100000,
            autores : "Pedro Juan",
            aColor : true,
            fechaVenta : "10-10-2019",
            estado : "activo"
        };

        /**
            * Creacion del objeto comic 2
            */  

        comic2 = {
            id : 654321,
            nombre : "Boku No Hero",
            editorial : "La obeja negra",
            tematica : "DOS",
            numeroPaginas : 1234,
            precio : 100000,
            autores : "Pedro Juan",
            aColor : true,
            fechaVenta : "10-10-2019",
            estado : "activo"
        };
        
        /**
            * Creacion del objeto comic 3
            */  

        comic3 = {
            id : 3456789,
            nombre : "Dragon Ball Z",
            editorial : "La obeja negra",
            tematica : "TRES",
            numeroPaginas : 1234,
            precio : 100000,
            autores : "Pedro Juan",
            aColor : true,
            fechaVenta : "10-10-2019",
            estado : "activo"
        };

        /**
            * Creacion del objeto comic 4
            */  

        comic4 = {
            id : 987654,
            nombre : "Shingeky No Kyogyn",
            editorial : "La obeja negra",
            tematica : "CUATRO",
            numeroPaginas : 1234,
            precio : 100000,
            autores : "Pedro Juan",
            aColor : true,
            fechaVenta : "10-10-2019",
            estado : "activo"
        };

        /**
            * Creacion del objeto comic 4
            */  

        comic5 = {
            id : 51928,
            nombre : "Naruto",
            editorial : "La obeja negra",
            tematica : "CINCO",
            numeroPaginas : 1234,
            precio : 100000,
            autores : "Pedro Juan",
            aColor : true,
            fechaVenta : "10-10-2019",
            estado : "activo"
        };

            /**
            * se agregan a la lista los objetos comic1 a comic5
            */  

        this.lista.push(comic1, comic2, comic3, comic4, comic5)

            /**
            * se convierte el objeto a una cadena de texto JSON.stringify
            */  

        this.listaObjeto = JSON.stringify(this.lista);
        console.log("--------------->" + this.lista[3].nombre );
        
        /**
         * Mensaje por consola
         */
        
        console.log("Ingreso al componente MostrarCiudadComponent")
                            
    }

            //Metodo EliminarItemComic el cual consiste en eliminar el
            //Elemento 3 de la lista que contiene los objetos,
            //utilizando splice, ademas muestra el mensaje del 
            //nombre del objeto eliminado

    public eliminarItemComic(item:number){
                
        if(this.verMensaje === false){
            let eliminado = this.lista.splice(item,1);        
            this.mensaje = "Se ha eliminado: " + eliminado[0].nombre;        
            this.verMensaje = true;
        }else{
            this.mensajeError = true;
        }
        
    }

    
}