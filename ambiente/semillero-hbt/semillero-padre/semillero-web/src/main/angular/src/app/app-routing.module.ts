import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { VerComicComponent } from './semillero/componentes/verComic/ver-comic-component';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'ver-comic', component: VerComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
