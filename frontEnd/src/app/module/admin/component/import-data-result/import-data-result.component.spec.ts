import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportDataResultComponent } from './import-data-result.component';

describe('ImportDataResultComponent', () => {
  let component: ImportDataResultComponent;
  let fixture: ComponentFixture<ImportDataResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ImportDataResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ImportDataResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
