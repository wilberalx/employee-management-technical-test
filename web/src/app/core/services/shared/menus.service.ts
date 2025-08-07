import { Injectable } from '@angular/core';
export interface MenuOption {
  route: string;
  menu: string;
  title: string;
  icon: string;
  dynamicTitle?: (url: string) => string;
}

@Injectable({ providedIn: 'root' })
export class MenuService {
  readonly menuOptions: MenuOption[] = [
    {
      route: '/employee-admin', menu: 'Employees', title: 'Employees administration', icon: 'group',
      dynamicTitle: (url: string) => {
        if (url === '/employee-admin/new') return 'Create employee';
        if (/^\/employee-admin\/\d+/.test(url)) return 'Edit employee';
        return 'Employees administration';
      }
    },
    { route: '/sales-report', menu: 'Sales report', title: 'Sales by employee', icon: 'bar_chart' },
  ];

  getTitleForUrl(url: string): string {
    const match = this.menuOptions.find(opt => url.startsWith(opt.route));
    if (!match) return '';
    return match.dynamicTitle ? match.dynamicTitle(url) : match.title;
  }
}
