/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Observable } from 'rxjs/Observable';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { HcPortalTestModule } from '../../../test.module';
import { DiabetesSugarTestComponent } from '../../../../../../main/webapp/app/entities/diabetes-sugar-test/diabetes-sugar-test.component';
import { DiabetesSugarTestService } from '../../../../../../main/webapp/app/entities/diabetes-sugar-test/diabetes-sugar-test.service';
import { DiabetesSugarTest } from '../../../../../../main/webapp/app/entities/diabetes-sugar-test/diabetes-sugar-test.model';

describe('Component Tests', () => {

    describe('DiabetesSugarTest Management Component', () => {
        let comp: DiabetesSugarTestComponent;
        let fixture: ComponentFixture<DiabetesSugarTestComponent>;
        let service: DiabetesSugarTestService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [DiabetesSugarTestComponent],
                providers: [
                    DiabetesSugarTestService
                ]
            })
            .overrideTemplate(DiabetesSugarTestComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DiabetesSugarTestComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DiabetesSugarTestService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN
                const headers = new HttpHeaders().append('link', 'link;link');
                spyOn(service, 'query').and.returnValue(Observable.of(new HttpResponse({
                    body: [new DiabetesSugarTest('123')],
                    headers
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.query).toHaveBeenCalled();
                expect(comp.diabetesSugarTests[0]).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
