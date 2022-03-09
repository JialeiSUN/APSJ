import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleCrudComponent } from './article-crud.component';

describe('ArticleCrudComponent', () => {
  let component: ArticleCrudComponent;
  let fixture: ComponentFixture<ArticleCrudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArticleCrudComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArticleCrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
