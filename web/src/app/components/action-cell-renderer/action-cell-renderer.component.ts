import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatIconButton } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-action-cell-renderer',
  templateUrl: './action-cell-renderer.component.html',
  standalone: true,
  imports: [
    CommonModule,
    MatIconModule,
    MatIconButton
  ],
})
export class ActionCellRendererComponent {
  params: any;

  agInit(params: any): void {
    this.params = params;
  }

  onClick(event: MouseEvent) {
    event.stopPropagation();
    if (this.params.onAction) {
      this.params.onAction(this.params.data);
    }
  }

}
