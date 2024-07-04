import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {BookRoutingModule} from './book-routing.module';
import {MenuComponent} from './pages/components/menu/menu.component';
import { BookListComponent } from './pages/components/book-list/book-list.component';
import { MainComponent } from './pages/main/main.component';
import { BookCardComponent } from './pages/components/book-card/book-card.component';
import { RatingComponent } from './pages/components/rating/rating.component';

@NgModule({
  declarations: [
    MenuComponent,
    BookListComponent,
    MainComponent,
    BookCardComponent,
    RatingComponent
  ],
  imports: [
    CommonModule,
    BookRoutingModule
  ]
})
export class BookModule {
}
