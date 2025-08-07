import { Component } from '@angular/core';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { SidebarComponent } from './pages/sidebar/sidebar.component';
import { NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MenuOption, MenuService } from './core/services/shared/menus.service';
import { Event } from '@angular/router';
import { filter } from 'rxjs/operators';
import { MatCardModule } from '@angular/material/card';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { LoadingService } from './core/services/shared/loading.service';
import { MatProgressBarModule } from '@angular/material/progress-bar';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    SidebarComponent,
    RouterOutlet,
    MatCardModule,
    MatSnackBarModule,
    MatProgressBarModule

  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  menuOpened = true;
  pageTitle: string = '';
  menuOptions: MenuOption[];
  isLoading$ = this.loadingService.loading$;

  constructor(
    private router: Router,
    private menuService: MenuService,
    private readonly loadingService: LoadingService
  ) {
    this.menuOptions = this.menuService.menuOptions;
    this.loadTitleProcess();
  }

  private loadTitleProcess(): void {
    this.router.events.pipe(
      filter((event: Event): event is NavigationEnd => event instanceof NavigationEnd)
    ).subscribe(event => {
      this.pageTitle = this.menuService.getTitleForUrl(event.urlAfterRedirects);
    });
  }

}
